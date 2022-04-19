window.addEventListener('load', function () {

     //Al cargar la pagina buscamos y obtenemos el formulario donde estarán
     //los datos que el usuario cargará del nuevo dentista
    const form = document.querySelector('#add_new_dentist');

    //Ante un submit del formulario se ejecutará la siguiente funcion
    form.addEventListener('submit', function (event) {

        //creamos un JSON que tendrá los datos del nuevo dentista
        const formData = {
            gmc: document.querySelector('#gmc').value,
            name: document.querySelector('#name').value,
            lastName: document.querySelector('#lastName').value,

        };

        //invocamos utilizando la función fetch la API dentistas con el método POST
        //que guardará al dentista que enviaremos en formato JSON
        const url = '/dentists';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
               //Si no hay ningun error se muestra un mensaje diciendo que el dentista se agregó sin problema
                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                     '<strong></strong> Dentist added successfully</div>'

                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";
                 //se dejan todos los campos vacíos por si se quiere ingresar otro dentista
                 resetUploadForm();

            })
            .catch(error => {
                 //Si hay algun error se muestra un mensaje diciendo que el dentista
                 //no se pudo guardar y se intente nuevamente
                  let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong> Unexpected error, please try again later</strong> </div>'

                   document.querySelector('#response').innerHTML = errorAlert;
                   document.querySelector('#response').style.display = "block";
                   //se dejan todos los campos vacíos por si se quiere ingresar otro dentista
                   resetUploadForm();})
    });

    function resetUploadForm(){
        document.querySelector('#gmc').value = "";
        document.querySelector('#name').value = "";
        document.querySelector('#lastName').value = "";
    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/dentistsList.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});