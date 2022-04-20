function deleteBy(id) {
  const url = "/odontologos/" + id;
  const settings = {
    method: "DELETE"
  };
  fetch(url, settings)
    .then((response) => {
      alert("eliminado");
    })
    .catch((error) => alert("error"));

  let row_id = "#tr_" + id;
  document.querySelector(row_id).remove();
}
