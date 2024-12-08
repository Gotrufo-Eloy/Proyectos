// script.js
const words = [
    { word: "javascript", hint: "Lenguaje de programación usado en la web" },
    { word: "coding", hint: "Actividad de escribir código" },
    { word: "playground", hint: "Lugar donde los niños juegan" }
];

let chosenIndex = Math.floor(Math.random() * words.length);
let chosenWord = words[chosenIndex].word;
let displayWord = "_ ".repeat(chosenWord.length).trim();
let attempts = 0;
const maxAttempts = 6;
let points = 0;
let wordsCompleted = 0;
const highscores = [];

const wordContainer = document.getElementById('word-container');
const attemptsCount = document.getElementById('attempts-count');
const pointsCount = document.getElementById('points-count');
const wordsCount = document.getElementById('words-count');
const hintContainer = document.getElementById('hint-container');
const messageContainer = document.getElementById('message-container');
const hintButton = document.getElementById('hint-button');
const lettersContainer = document.getElementById('letters-container');
const highscoresTable = document.getElementById('highscores-table');

wordContainer.textContent = displayWord;
attemptsCount.textContent = '❤'.repeat(maxAttempts - attempts);
pointsCount.textContent = points;
wordsCount.textContent = wordsCompleted;

for (let i = 65; i <= 90; i++) {
    let button = document.createElement('button');
    button.textContent = String.fromCharCode(i);
    button.addEventListener('click', () => handleGuess(String.fromCharCode(i)));
    lettersContainer.appendChild(button);
}

hintButton.addEventListener('click', showHint);
document.getElementById('save-name-button').addEventListener('click', savePlayerName);

function handleGuess(letter) {
    let newDisplay = '';
    let correctGuess = false;
    let occurrences = 0;

    for (let i = 0; i < chosenWord.length; i++) {
        if (chosenWord[i].toUpperCase() === letter) {
            newDisplay += chosenWord[i] + ' ';
            correctGuess = true;
            occurrences++;
        } else {
            newDisplay += displayWord[i * 2] + ' ';
        }
    }

    if (!correctGuess) {
        attempts++;
        attemptsCount.textContent = '❤'.repeat(maxAttempts - attempts);
        if (attempts >= maxAttempts) {
            messageContainer.textContent = '¡Has perdido!';
            hintButton.style.visibility = 'hidden';
            hintContainer.innerHTML = '<button id="restart-button" onclick="showNamePrompt()">Jugar Ahora</button>';
            document.querySelectorAll("#letters-container button").forEach(button => button.disabled = true);
        }
    } else {
        points += 25 * occurrences;
        pointsCount.textContent = points;
        document.querySelectorAll("#letters-container button").forEach(button => {
            if (button.textContent === letter) button.disabled = true;
        });
    }
    displayWord = newDisplay.trim();
    wordContainer.textContent = displayWord;

    if (displayWord.split(" ").join("") === chosenWord) {
        messageContainer.textContent = '¡Felicidades! Has completado la palabra.';
        wordsCompleted++;
        wordsCount.textContent = wordsCompleted;
        setTimeout(startNewWord, 2000);
    }
}

function showHint() {
    if (points >= 100) {
        hintContainer.innerHTML = <h3>Pista</h3>${words[chosenIndex].hint};
        points -= 100;
        pointsCount.textContent = points;
        hintButton.disabled = true;
        hintButton.style.visibility = 'hidden';
    } else if (attempts <= maxAttempts - 2) {
        hintContainer.innerHTML = <h3>Pista</h3>${words[chosenIndex].hint};
        attempts += 2;
        attemptsCount.textContent = '❤'.repeat(maxAttempts - attempts);
        hintButton.disabled = true;
        hintButton.style.visibility = 'hidden';
    } else {
        messageContainer.textContent = 'No tienes suficientes puntos o vidas para comprar una pista.';
    }
}

function startNewWord() {
    chosenIndex = Math.floor(Math.random() * words.length);
    chosenWord = words[chosenIndex].word;
    displayWord = "_ ".repeat(chosenWord.length).trim();
    wordContainer.textContent = displayWord;
    messageContainer.textContent = '';
    hintContainer.innerHTML = '';
    hintButton.disabled = false;
    hintButton.style.visibility = 'visible';
    document.querySelectorAll("#letters-container button").forEach(button => button.disabled = false);
}

function showNamePrompt() {
    document.getElementById('name-prompt-container').classList.remove('hidden');
}

function savePlayerName() {
    const playerName = document.getElementById('player-name').value;
    document.getElementById('name-prompt-container').classList.add('hidden');
    if (playerName) {
        addHighscore(playerName, points, wordsCompleted);
    }
    resetGame();
}

function resetGame() {
    chosenIndex = Math.floor(Math.random() * words.length);
    chosenWord = words[chosenIndex].word;
    displayWord = "_ ".repeat(chosenWord.length).trim();
    attempts = 0;
    points = 0;
    wordsCompleted = 0;
    wordContainer.textContent = displayWord;
    attemptsCount.textContent = '❤'.repeat(maxAttempts - attempts);
    pointsCount.textContent = points;
    wordsCount.textContent = wordsCompleted;
    messageContainer.textContent = '';
    hintContainer.innerHTML = '';
    hintButton.disabled = false;
    hintButton.style.visibility = 'visible';
    document.getElementById('player-name').value = '';
    document.querySelectorAll("#letters-container button").forEach(button => button.disabled = false);
}

function addHighscore(name, points, words) {
    highscores.push({ name, points, words });
    highscores.sort((a, b) => b.points !== a.points ? b.points - a.points : b.words - a.words);
    if (highscores.length > 5) {
        highscores.length = 5;
    }
    displayHighscores();
}

function displayHighscores() {
    highscoresTable.innerHTML = `
        <tr>
            <th>Posición</th>
            <th>Puntos</th>
            <th>Palabras</th>
            <th>Nombre</th>
        </tr>`;
    
    highscores.forEach((score, index) => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${index + 1}</td>
            <td>${score.points}${index === 0 ? ' 🥇' : index === 1 ? ' 🥈' : index === 2 ? ' 🥉' : ''}</td>
            <td>${score.words}</td>
            <td>${score.name}</td>`;
        highscoresTable.appendChild(row);
    });
}

displayHighscores();