// Call the dataTables jQuery plugin
document.addEventListener("DOMContentLoaded", () => {
  const loginform = document.getElementById("formulario_login");
  loginform.addEventListener("submit", function (event) {
    iniciarSesion();
  });
});

async function iniciarSesion() {
  // Recoger los datos del formulario
  let datos = {};
  datos.email = document.getElementById("txtEmail").value;
  datos.password = document.getElementById("txtPassword").value;
  console.log("iniciar secion");
  // Realizar la solicitud POST a la API
  const request = await fetch("http://localhost:8081/api/login", {
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(datos),
  });

  // const respuesta = await request.json();

  if (request.status === 200) {
    // Si el estado es 200 (OK)
    window.location.href = "/usuarios.html"; // Redirect to /usuarios.html
  } else {
    alert("usuario o contraseña invalidos");
  }
}
