window.addEventListener("load", function () {
  const formulario = document.querySelector("#add_new_dentist");

  formulario.addEventListener("submit", function (event) {
    const formData = {
      numeroMatricula: document.querySelector("#matricula").value,
      apellido: document.querySelector("#apellido").value,
      nombre: document.querySelector("#nombre").value,
    };

    const url = "/odontologos";
    const settings = {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        mode: 'no-cors' 
      },
      body: JSON.stringify(formData),
    };

    fetch(url, settings)
      .then((response) => {
        alert("guardado");
        resetUploadForm();
      })
      .catch((error) => {
        alert("error");
      });
  });
  function resetUploadForm() {
    document.querySelector("#matricula").value = "";
    document.querySelector("#nombre").value = "";
    document.querySelector("#apellido").value = "";
  }

  (function () {
    let pathname = window.location.pathname;
    if (pathname === "/") {
      document.querySelector(".nav .nav-item a:first").addClass("active");
    } else if (pathname == "/listadoOdontologos.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
    }
  })();
});
