let lastActivityTime;
const IDLE_TIMEOUT_DURATION = 9000; //milliseconds

// Add an event listener to a button that triggers the toggle function
function toggleSignupSection() {
    var signupSection = document.getElementById('signupsection');
    var signinSection = document.getElementById('signinsection');
    signinSection.style.display = 'none';
    signupSection.style.display = 'block';
}

function toggleSigninSection() {
    var signupSection = document.getElementById('signupsection');
    var signinSection = document.getElementById('signinsection');
    signinSection.style.display = 'block';
    signupSection.style.display = 'none';

}

function checkLogin() {
    if (localStorage.getItem("username") != null && localStorage.getItem("password") != null) {
        console.log("User already logged in");
        return true;
    } else {
        console.log("User not logged in");
        var signupButton = document.getElementById('signupButton');
        //signupButton.click();
        return false;
    }
}


function login() {
    let username = "";
    let password = "";
    // Get username and password
    username = document.getElementById("username").value;
    password = document.getElementById("password").value;
    //Backend verification

    // Print username and password
    console.log('LOGIN :', username, password);
    //Set idle timeout
    lastActivityTime = Date.now();

    //set username and password
    localStorage.setItem("username", username);
    localStorage.setItem("password", password);
}



//If user logged in but idle exceed time limit then logout
function checkIdleTimeout() {
    const currentTime = Date.now();
    const idleTime = currentTime - lastActivityTime;

    if (localStorage.getItem("username") != null && localStorage.getItem("password") != null) {
        if (idleTime >= IDLE_TIMEOUT_DURATION) {
            logout();
        } else {
            const remainingTime = IDLE_TIMEOUT_DURATION - idleTime;
            console.log(`You idled ${remainingTime / 1000} seconds!`);
            lastActivityTime = Date.now();
        }
    }
}
// Reset the timer on user activity (e.g., mousemove, keydown, etc.)
document.addEventListener('mousemove', checkIdleTimeout);
document.addEventListener('keydown', checkIdleTimeout);
document.addEventListener('mousedown', checkIdleTimeout); // touchscreen presses
document.addEventListener('touchstart', checkIdleTimeout);
document.addEventListener('touchmove', checkIdleTimeout);



function logout() {
    localStorage.clear("username");
    localStorage.clear("password");
    console.log("LOGOUT");
    //window.location.href = "index.html";
}