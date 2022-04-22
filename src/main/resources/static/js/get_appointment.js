window.addEventListener("load", function () {
  (function () {
    const url = "/turnos";
    const settings = {
      method: "GET"
    };
    fetch(url, settings)
      .then((response) => response.json())
      .then((response) => {
        for (appointment of response) {
          var table = document.getElementById("appointmentTable");
          var appointmentRow = table.insertRow();
          let tr_id = "tr_" + appointment.id;
          appointmentRow.id = tr_id;

          let deleteButton =
            "<button" +
            " id=" +
            '"' +
            "btn_delete_" +
            appointment.id +
            '"' +
            ' type="button" onclick="deleteBy(' +
            appointment.id +
            ')" class="btn btn-danger btn_delete">' +
            "&times" +
            "</button>";

          let updateButton =
            "<button" +
            " id=" +
            '"' +
            "btn_id_" +
            appointment.id +
            '"' +
            ' type="button" onclick="findBy(' +
            appointment.id +
            ')" class="btn btn-outline-dark btn_id">' +
            appointment.id +
            "</button>";

          appointmentRow.innerHTML =
            "<td>" +
            updateButton +
            "</td>" +
            '<td class="td_last_name">' +
            appointment.odontologo.apellido +
            "</td>" +
            '<td class="td_last_name">' +
            appointment.paciente.apellido+
            "</td>" +
            '<td class="td_last_name">' +
            appointment.fechaHora+
            "</td>" +
            "<td>" +
            deleteButton +
            "</td>";
        }
      });
  })(function () {
    let pathname = window.location.pathname;
    if (pathname == "listadoTurnos.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
    }
  });
});
