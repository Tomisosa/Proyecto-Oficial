$(document).ready(function() {

});

async function registrarUsuarios(){
    //creamos una variable de tipo array que contenga los datos
    let datos={};
    //capturamos los datos con el id de los inputs
    datos.nombre=document.getElementById('txtNombre').value;
    datos.apellido=document.getElementById('txtApellido').value;
    datos.email=document.getElementById('txtEmail').value;
    datos.telefono=document.getElementById('txtTelefono').value;
    datos.password=document.getElementById('txtPassword').value;

    let repetirPassword=document.getElementById('txtRepetirPassword').value;

    //para corroborar que las contraseñas coincidan
    if(repetirPassword != datos.password){
        alert('la contraseña es incorrecta')
        return;
    }

  const request = await fetch('http://localhost:8081/api/usuarios', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body:JSON.stringify(datos)
  });
  window.location.href="login.html"
  //const usuarios = await request.json();

  //let listadoHTML='';
}
