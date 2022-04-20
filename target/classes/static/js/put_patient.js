window.addEventListener("load", function () {
  const formulario = document.querySelector("#update_dentist_form");
  formulario.addEventListener("submit", function (event) {
    let patientId = document.querySelector("#patient").value;

    let formData = {
      id: document.querySelector("#patient").value,
      dni: document.querySelector("#dni").value,
      nombre: document.querySelector("#nombre").value,
      apellido: document.querySelector("#apellido").value,
    };

    const url = "/pacientes/" + patientId;
    const settings = {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
        
      },
      body: JSON.stringify(formData),
    };
    fetch(url, settings).then((response) => alert("guardado"));
  });
});

function findBy(id) {
  const url = "/pacientes/" + id;
  const settings = {
    method: "GET",
  };
  fetch(url, settings)
    .then((response) => response.json())
    .then((data) => {
      document.querySelector("#div_patient_updating").style.display = "block";
      let patient = data;
      document.querySelector("#patient").value = patient.id;
      document.querySelector("#dni").value = patient.dni;
      document.querySelector("#apellido").value = patient.apellido;
      document.querySelector("#nombre").value = patient.nombre;
    })
    .catch((error) => {
      alert("Error: " + error);
    });
}
