document.getElementById('registerForm').addEventListener('submit', async (e) => {
    e.preventDefault();

    const name = document.getElementById('name').value;
    const cpf = document.getElementById('cpf').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const accountNumber = document.getElementById('accountNumber').value;
    const agencyNumber = document.getElementById('agencyNumber').value;
    const balance = document.getElementById('balance').value;


    try {
        const response = await fetch('/api/clients/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ name, cpf, email, password, accountNumber, agencyNumber, balance })
        });

        if (response.ok) {
            alert('Cadastro realizado com sucesso!');
            window.location.href = '/login.html';
        } else {
            const data = await response.json();
            document.getElementById('errorMsg').innerText = data.message || 'Erro no cadastro';
        }
    } catch (err) {
        console.error(err);
        document.getElementById('errorMsg').innerText = 'Erro ao conectar com o servidor';
    }
});
