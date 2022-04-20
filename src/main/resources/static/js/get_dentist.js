window.addEventListener("load", function () {
  (function () {
    const url = "/odontologos";
    const settings = {
      method: "GET"
    };
    fetch(url, settings)
      .then((response) => response.json())
      .then((response) => {
        for (dentist of response) {
          var table = document.getElementById("dentistTable");
          var dentistRow = table.insertRow();
          let tr_id = "tr_" + dentist.id;
          dentistRow.id = tr_id;

          let deleteButton =
            "<button" +
            " id=" +
            '"' +
            "btn_delete_" +
            dentist.id +
            '"' +
            ' type="button" onclick="deleteBy(' +
            dentist.id +
            ')" class="btn btn-danger btn_delete">' +
            "&times" +
            "</button>";

          let updateButton =
            "<button" +
            " id=" +
            '"' +
            "btn_id_" +
            dentist.id +
            '"' +
            ' type="button" onclick="findBy(' +
            dentist.id +
            ')" class="btn btn-outline-dark btn_id">' +
            dentist.id +
            "</button>";

          dentistRow.innerHTML =
            "<td>" +
            updateButton +
            "</td>" +
            '<td class="td_first_name">' +
            dentist.nombre +
            "</td>" +
            '<td class="td_last_name">' +
            dentist.apellido +
            "</td>" +
            "<td>" +
            deleteButton +
            "</td>";
        }
      });
  })(function () {
    let pathname = window.location.pathname;
    if (pathname == "listadoOdontologos.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
    }
  });
});
