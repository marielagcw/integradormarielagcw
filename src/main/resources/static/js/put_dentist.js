window.addEventListener("load", function () {
  const formulario = document.querySelector("#update_dentist_form");
  formulario.addEventListener("submit", function (event) {
    let dentistId = document.querySelector("#dentist").value;

    let formData = {
      id: document.querySelector("#dentist").value,
      numeroMatricula: document.querySelector("#matricula").value,
      nombre: document.querySelector("#nombre").value,
      apellido: document.querySelector("#apellido").value,
    };

    const url = "/odontologos/" + dentistId;
    const settings = {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formData),
    };
    fetch(url, settings).then((response) => response.json());
  });
});

function findBy(id) {
  const url = "/odontologos/" + id;
  const settings = {
    method: "GET",
  };
  fetch(url, settings)
    .then((response) => response.json())
    .then((data) => {
      document.querySelector("#div_dentist_updating").style.display = "block";
      let dentist = data;
      document.querySelector("#dentist").value = dentist.id;
      document.querySelector("#matricula").value= dentist.numeroMatricula;
      document.querySelector("#apellido").value = dentist.apellido;
      document.querySelector("#nombre").value = dentist.nombre;      
    })
    .catch((error) => {
      alert("Error: " + error);
    });
}
