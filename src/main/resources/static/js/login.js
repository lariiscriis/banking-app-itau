document.getElementById('loginForm').addEventListener('submit', async (e) => {
    e.preventDefault();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    try {
        const response = await fetch('/api/clients/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ email, password })
        });

        if (response.ok) {
            const token = await response.text();
            localStorage.setItem('token', token);
            window.location.href = '/dashboard.html';
        } else {
            document.getElementById('errorMsg').innerText = 'Email ou senha incorretos';
        }
    } catch (err) {
        console.error(err);
        document.getElementById('errorMsg').innerText = 'Erro ao conectar com o servidor';
    }
});
