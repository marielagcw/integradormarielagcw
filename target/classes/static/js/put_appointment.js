window.addEventListener("load", function () {
  const formulario = document.querySelector("#update_appointment_form");
  formulario.addEventListener("submit", function (event) {
    let appointmentId = document.querySelector("#appointment").value;

    let formData = {
      id: document.querySelector("#appointment").value,
      fechaHora: document.querySelector("#fechaHora").value,
      odontologo: { id: document.querySelector("#idOdontologo").value },
      paciente: { id: document.querySelector("#idPaciente").value },
    };

    const url = "/turnos/" + appointmentId;
    const settings = {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
        mode: "no-cors",
        referrerPolicy: "no-referrer-when-downgrade",
      },
      body: JSON.stringify(formData),
    };
    fetch(url, settings)
      .then(() => response.json())
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
        cargarListaOdontologos();
      });
  });
});

function findBy(id) {
  const url = "/turnos/" + id;
  const settings = {
    method: "GET",
  };
  fetch(url, settings)
    .then((response) => response.json())
    .then((data) => {
      document.querySelector("#div_appointment_updating").style.display =
        "block";
      let appointment = data;
      document.querySelector("#appointment").value = appointment.id;
      document.querySelector("#fechaHora").value = appointment.fechaHora;
      document.querySelector("#idOdontologo").value = appointment.odontologo.id;
      document.querySelector("#idPaciente").value = appointment.paciente.id;
    })
    .catch((error) => {
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: "Algo salió mal, intenta de nuevo",
      });
    });
}
