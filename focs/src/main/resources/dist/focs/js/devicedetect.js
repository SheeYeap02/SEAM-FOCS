
function detector() {
    const parts = navigator.userAgent.split('/');
    console.log(parts[0]);
    console.log(parts[1]);
    fetch('https://api.ipify.org/?format=json').then(results => results.json()).then(data => console.log(data.ip));
}

detector();
