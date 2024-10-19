 async function fetchData() {
    try{
        const response = await fetch('http://localhost:4000/todos');
        if (!response) {
            throw new Error('Network response was not ok');
        }
        const data = await response.json();
        console.log('data from the server:',data);

            const todol=document.getElementById('todo__List');
            todol.innerHTML ='';

            data.forEach(item => {
                let listItem = document.createElement('li');
                todol.appendChild(listItem);
                let editbutton = document.createElement('button');
                editbutton.textContent ="Edit";
                editbutton.id="btn1";
                editbutton.onclick = function () {
                    clickedit(item);
                    
                };
                listItem.appendChild(editbutton);

                let deletebutton = document.createElement('button');
                deletebutton.textContent ="delete";
                deletebutton.id="btn2";
                deletebutton.onclick = function () {
                    clickedit(item._id);
                    
                };
                listItem.appendChild(deletebutton);
                
            });
        }
            catch(error){
                console.error('Error fetching data',error.message);
            }

    }
 

fetchData();
 async function createtodo() {
    try{
        let li = document.getElementById('title')
        let des = document.getElementById('description') 
        let data ={titlt:ti.value,description:des.value}
        const response = await fetch('http://localhost:4000/todos',{
        method :"POST",
        headers: {
            'Content-Type' : 'application/json',
        },
        body: JSON.stringify(data)
 

        }).then(response =>{
            if(!response) {
                throw new Error('Network response was not ok');
            }
            const res = response.json();
            console.log(res,"fffff")
            ti.value=""
            des.value=""
            fetchData();
        })
        

    }
    catch(error){
        console.error(' fetching data:', error.message); 
    }
    
}
 async function clickedit(item){



    try{
     const saveButton = document.getElementById('bbtn')
     saveButton.textContent = "update";
     const tButton = document.getElementById('title')
     tButton.value = item.title;
     const dButton = document.getElementById('description')
     dButton.value = item.description;

     saveButton.onclick = async() =>{
        try{
            let ti =   tButton.value;
            let des = dButton.value;
            let data = {title:ti,description:des};

            const response = await fetch(`http://localhost:4000/todos`,{
                method :"PUT",
                headers: {
                    'Content-Type' : 'application/json',
                },
                body: JSON.stringify(data)
         
        
                });
                    if(!response) {
                        throw new Error('Network response was not ok');
                    }
                    const res =  await response.json();
                    
                    fetchData();
                
                
                    saveButton.textContent= "Save";

                    tButton.value='';
                    dButton.value='';
                }


                catch(error){
                    console.error(' fetching data:', error.message); 
                }

            
        }
         
        }
        catch(error){
            console.error(' fetching data:', error.message); 

     }
    }


  async function clickdelete(id) {
    let response =  await fetch(`http://localhost:4000/todos/${id}`,{
        method :"DELETE",
    }).then((res) =>{
        console.log(res,"res")
        fetchData();
    })
    
}


