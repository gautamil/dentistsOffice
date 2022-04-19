window.addEventListener('load', function () {

    //Buscamos y obtenemos el formulario donde estan
    //los datos que el usuario pudo haber modificado del dentista
    const form = document.querySelector('#update_dentist_form');
    form.addEventListener('submit', function (event) {
        let dentistId = document.querySelector('#dentist_id').value;

        //creamos un JSON que tendrá los datos del dentista
        //a diferencia de un dentista nuevo en este caso enviamos el id
        //para poder identificarlo y modificarlo para no cargarlo como nuevo
        const formData = {
            id: document.querySelector('#dentist_id').value,
            gmc: document.querySelector('#gmc').value,
            name: document.querySelector('#name').value,
            lastName: document.querySelector('#lastName').value,

        };

        //invocamos utilizando la función fetch la API dentistas con el método PUT
        //que modificará al dentista que enviaremos en formato JSON
        const url = '/dentists';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())

    })
 })

    //Es la funcion que se invoca cuando se hace click sobre el id de un dentista del listado
    //se encarga de llenar el formulario con los datos del dentista
    //que se desea modificar
    function findBy(id) {
          const url = '/dentists'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let student = data;
              document.querySelector('#dentist_id').value = dentist.id;
              document.querySelector('#gmc').value = dentist.gmc;
              document.querySelector('#name').value = dentist.name;
              document.querySelector('#lastName').value = dentist.lastName;

            //el formulario por default esta oculto y al editar se habilita
              document.querySelector('#div_dentist_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
      }