console.log("**JS**");

const titulo = document.getElementById("titulo");
const listaActos = document.getElementById("listaActos");

// 0. Cambio de Título SIN BOTÓN
titulo.textContent = "¡Bienvenidos al Espectáculo Más Asombroso del Mundo!";

// 1. Añadir un Elemento SIN BOTÓN
const actoInicial = document.createElement("li");
actoInicial.textContent = "Acróbatas Increíbles";

listaActos.appendChild(actoInicial);