const token = localStorage.getItem("token");

if (!token) {
    window.location.href = "/login.html";
}

const headers = { "Authorization": "Bearer " + token };
let clientData = null;

async function loadClient() {
    const response = await fetch("/api/clients/me", { headers });
    clientData = await response.json();

    document.getElementById("clientName").textContent = clientData.name;
    document.getElementById("agencyNumber").textContent = clientData.agencyNumber;
    document.getElementById("accountNumber").textContent = clientData.accountNumber;
    document.getElementById("balance").textContent = clientData.balance;
}

loadClient();

function addHistory(text) {
    const li = document.createElement("li");
    li.textContent = text + " (" + new Date().toLocaleString() + ")";
    document.getElementById("historyList").appendChild(li);
}

function openModal(id) {
    document.getElementById(id).style.display = "block";
}

function closeModal(id) {
    document.getElementById(id).style.display = "none";
}

async function deposit() {
    const amount = document.getElementById("depositAmount").value;

    await fetch(`/api/clients/${clientData.accountNumber}/deposit?amount=${amount}`, {
        method: "POST",
        headers
    });

    closeModal("depositModal");
    addHistory("Depósito de R$ " + amount);
    loadClient();
}

async function withdraw() {
    const amount = document.getElementById("withdrawAmount").value;

    await fetch(`/api/clients/${clientData.accountNumber}/withdraw?amount=${amount}`, {
        method: "POST",
        headers
    });

    closeModal("withdrawModal");
    addHistory("Saque de R$ " + amount);
    loadClient();
}

async function transfer() {
    const toAccount = document.getElementById("toAccount").value;
    const amount = document.getElementById("transferAmount").value;

    await fetch(`/api/clients/transfer?fromAccountNumber=${clientData.accountNumber}&toAccountNumber=${toAccount}&amount=${amount}`, {
        method: "POST",
        headers
    });

    closeModal("transferModal");
    addHistory(`Transferência de R$ ${amount} para conta ${toAccount}`);
    loadClient();

}

document.getElementById("logoutBtn").addEventListener("click", () => {
    localStorage.removeItem("token");
    window.location.href = "login.html";
});