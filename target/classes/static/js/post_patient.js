window.addEventListener("load", function () {
  const formulario = document.querySelector("#add_new_patient");

  formulario.addEventListener("submit", function (event) {
    const formData = {
      dni: document.querySelector("#dni").value,
      apellido: document.querySelector("#apellido").value,
      nombre: document.querySelector("#nombre").value,
    };

    const url = "/pacientes";
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
        resetUploadForm();
      });
  });

  function resetUploadForm() {
    document.querySelector("#dni").value = "";
    document.querySelector("#nombre").value = "";
    document.querySelector("#apellido").value = "";
  }

  (function () {
    let pathname = window.location.pathname;
    if (pathname === "/") {
      document.querySelector(".nav .nav-item a:first").addClass("active");
    } else if (pathname == "/listadoPacientes.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
    }
  })();
});
