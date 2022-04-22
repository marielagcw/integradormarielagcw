window.addEventListener("load", function () {
  const formulario = document.querySelector("#add_new_appointment");

  formulario.addEventListener("submit", function (event) {
    event.preventDefault();

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
        mode: "no-cors",
      },
      body: JSON.stringify(formData),
    };

    fetch(url, settings)
      .then((response) => {
        if (response.status == 200) {
          Swal.fire({
            icon: "success",
            title: "Genial!",
            text: "Los datos fueron guardado con éxito!",
          });
        } else {
          Swal.fire({
            icon: "error",
            title: "Oops...",
            text: "Algo salió mal, intenta de nuevo",
          });
        }
        resetUploadForm();
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
});
