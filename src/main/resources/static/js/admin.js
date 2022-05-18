async function getAllUsers() {
    const res = await fetch('http://localhost:8080/admin/allUsers');
    const users = await res.json();

    users.forEach(user => userToHTML(user))
}

window.addEventListener('DOMContentLoaded', getAllUsers);

document.getElementById('addUser').addEventListener('click', async () => {
        const nameInput = document.getElementById('name');
        const emailInput = document.getElementById('email');
        const passwordInput = document.getElementById('password');
        const name = nameInput.value;
        const email = emailInput.value;
        const password = passwordInput.value;

        if (name && email && password) {
            const res = await fetch('http://localhost:8080/admin/addUser', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({name, email, password})
            });

            const user = await res.json();
            userToHTML(user);

            userNameInput.value = '';
            emailInput.value = '';
            passwordInput.value = '';
        }
    }
)

function userToHTML(user) {
    const userList = document.getElementById('users');
    userList.insertAdjacentHTML('beforeend',
        `    <div class="form-check" id="user${user.id}">
                      ${user.name}
                     <button onclick="deleteUser(${user.id})" type="button" class="btn-close"
                aria-label="Close" style="font-size: 10px">Х</button>
                   </div>`
    );
}


async function deleteUser(id) {
    const res = await fetch(` http://localhost:8080/admin/deleteUser/${id}`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        }
    });

    const data = await res.json();

    if (data) {
        document.getElementById(`user${id}`).remove();
    }
}

// async function update(id) {
//     const res = await fetch(` http://localhost:8080/admin/update/${id}`, {
//         method: 'PUT',
//         headers: {
//             'Content-Type': 'application/json',
//         },
//         body: JSON.stringify({})
//     })
//     const data = await res.json();
//     console.log(data);
// }