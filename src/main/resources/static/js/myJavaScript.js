const formAgregrar = document.getElementById("formAgregar");
const formEditar = document.getElementById("formEditar");
const btnAgregar = document.getElementById("botonAgregar");
const btnEditar = document.getElementById("botonEditar");
btnAgregar.onclick = function () {
    if (formAgregrar.style.display !== "none") {
        formAgregrar.style.display = "none";
    } else {
        formAgregrar.style.display = "block";
        formEditar.style.display = "none";
    }
};

btnEditar.onclick = function () {
    if (formEditar.style.display !== "none") {
        formEditar.style.display = "none";
    } else {
        formEditar.style.display = "block";
        formAgregrar.style.display = "none";
    }
};