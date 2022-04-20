window.addEventListener("load", function () {
  const formulario = document.querySelector("#add_new_appointment");

  formulario.addEventListener("submit", function (event) {
    const formData = {
      fechaHora: document.querySelector("#fechaHora").value,
      odontologo: { id: document.querySelector("#idOdontologo").value },
      paciente: { id: document.querySelector("#idPaciente").value },
    };

    const url = "/turnos";
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
    document.querySelector("#fechaHora").value = "";
    document.querySelector("#idOdontologo").value = "";
    document.querySelector("#idPaciente").value = "";
  }

  (function () {
    let pathname = window.location.pathname;
    if (pathname === "/") {
      document.querySelector(".nav .nav-item a:first").addClass("active");
    } else if (pathname == "listadoTurnos.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
    }
  })();
});
