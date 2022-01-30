$(document).ready(function () {
    cargarGruposAlHorario();
});

async function cargarGruposAlHorario() {

    const request = await fetch('/cronus/private/student/schedule', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });

    const grupos = await request.json();


    for (const grupo of grupos) {
        let string = grupo.subjectName +"<br>"
            + "Grupo " + grupo.number +"<br>"
            + grupo.teacherName + " " + grupo.teacherLastName;

        let splitedHours = grupo.hours.split(";");
        let id1 = splitedHours[0];
        let id2 = splitedHours[1];

        document.getElementById(id1).innerHTML = string;
        document.getElementById(id2).innerHTML = string;
    }


}

async function agregarGrupoAHorario(grupoNumber, hours, subjectName, teacherName, teacherLastName, subjectCode){

    let splitedHours = hours.split(";");
    let string = subjectName +"<br>"
        + "Grupo " + grupoNumber +"<br>"
        + teacherName + " " + teacherLastName;

    if (materiaExisteEnHorario(splitedHours, string)){
        Swal.fire({
            title: "Atención!",
            showDenyButton: true,
            text: "Este grupo ya ha sido añadido previamente",
            icon: "warning",
            confirmButtonText : "Aceptar",
            denyButtonText: "Eliminar grupo del horario",
        }).then((result) => {
            // Borrar del horario el grupo
            if (result.isDenied) {
                for (const id of splitedHours) {
                    document.getElementById(id).innerHTML = "";
                }
                eliminarGrupoEnBd(grupoNumber, subjectCode);
            }
        });

    }
    else if (vefMateriasSolapadas(splitedHours)){
        Swal.fire({
            title: "Atención!",
            text: "Ya existe un grupo con el horario seleccionado",
            icon: "warning",
            confirmButtonText : "Seleccionar otro grupo",
        });
    }else{

        let grupoDto = {};

        grupoDto.number = grupoNumber;
        grupoDto.subjectCode = subjectCode;

        const request = await fetch('/cronus/private/student/schedule', {
            method: 'POST',
            credentials: 'include',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(grupoDto)
        });

        const respuesta = await request.text();

        if (respuesta == 'FAIL'){
            Swal.fire({
                title: "Atención!",
                text: "Ya elegiste un grupo para esa materia compa",
                icon: "warning",
                confirmButtonText : "Aceptar",
            });
        }else {
            Swal.fire({
                title: "Bien!",
                text: "Se ha agregado correctamente el grupo a tu horario",
                icon: "success",
                confirmButtonText : "Aceptar",
            }).then((result) => {
                // Añadir el grupo al horario
                if (result.isConfirmed) {
                    // Se agrega el grupo al horario del estudiante
                    for (const id of splitedHours) {
                        document.getElementById(id).innerHTML = string;
                    }
                }
            });
        }

    }


}

async function eliminarGrupoEnBd(grupoNumber, subjectCode) {

    let grupoDto = {};
    grupoDto.number = grupoNumber;
    grupoDto.subjectCode = subjectCode;

    const request = await fetch('/cronus/private/student/schedule', {
        method: 'DELETE',
        credentials: 'include',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(grupoDto)
    });
}



function materiaExisteEnHorario(splitedHours, string) {
    for (const id of splitedHours) {
        if (document.getElementById(id).innerHTML == string){
            return true;
        }
    }
}


function vefMateriasSolapadas(splitedHours){

    return document.getElementById(splitedHours[0]).innerHTML != "" || document.getElementById(splitedHours[1]).innerHTML != "";
}