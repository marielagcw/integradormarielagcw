window.addEventListener("load", function () {
  (function () {
    const url = "/pacientes";
    const settings = {
      method: "GET"
    };
    fetch(url, settings)
      .then((response) => response.json())
      .then((response) => {
        for (patient of response) {
          var table = document.getElementById("patientTable");
          var patientRow = table.insertRow();
          let tr_id = "tr_" + patient.id;
          patientRow.id = tr_id;

          let deleteButton =
            "<button" +
            " id=" +
            '"' +
            "btn_delete_" +
            patient.id +
            '"' +
            ' type="button" onclick="deleteBy(' +
            patient.id +
            ')" class="btn btn-danger btn_delete">' +
            "&times" +
            "</button>";

          let updateButton =
            "<button" +
            " id=" +
            '"' +
            "btn_id_" +
            patient.id +
            '"' +
            ' type="button" onclick="findBy(' +
            patient.id +
            ')" class="btn btn-outline-dark btn_id">' +
            patient.id +
            "</button>";

          patientRow.innerHTML =
            "<td>" +
            updateButton +
            "</td>" +
            '<td class="td_first_name">' +
            patient.nombre +
            "</td>" +
            '<td class="td_last_name">' +
            patient.apellido +
            "</td>" +
            "<td>" +
            deleteButton +
            "</td>";
        }
      });
  })(function () {
    let pathname = window.location.pathname;
    if (pathname == "listadoPacientes.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
    }
  });
});
