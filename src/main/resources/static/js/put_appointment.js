window.addEventListener("load", function () {
  const formulario = document.querySelector("#update_appointment_form");
  formulario.addEventListener("submit", function (event) {
    let appointmentId = document.querySelector("#appointment").value;

    let formData = {
      id: document.querySelector("#appointment").value,
      fechaHora: document.querySelector("#fechaHora").value,
      odontologo: document.querySelector("#idOdontologo").value,
      paciente: document.querySelector("#idPaciente").value,
    };

    const url = "/turnos/" + appointmentId;
    const settings = {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formData),
    };
    fetch(url, settings).then((response) => alert("Guardado"));
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
      alert("Error: " + error);
    });
}
