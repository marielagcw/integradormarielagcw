function deleteBy(id) {
  const url = "/turnos/" + id;
  const settings = {
    method: "DELETE"
  };
  fetch(url, settings)
    .then((response) => {
      Swal.fire({
        icon: "success",
        title: "Genial!",
        text: "Los datos fueron eliminados con éxito!",
      });
    })
    .catch((error) => 
    Swal.fire({
      icon: 'error',
      title: 'Oops...',
      text: 'Algo salió mal, intenta de nuevo',
    }));

  let row_id = "#tr_" + id;
  document.querySelector(row_id).remove();
}
