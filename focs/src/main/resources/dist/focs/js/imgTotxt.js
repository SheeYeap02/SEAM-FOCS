const tessaract = require('tesseract.js');

const img = '/focs/src/main/resources/dist/assets/compiled/jpg/spmcert.jpg';
const img2 = '/focs/src/main/resources/dist/assets/compiled/jpg/spmcert2.jpg';

const imgTotxt2 = async (img) => {
    const out = await tessaract.recognize(img, 'eng', {});
    const txt = out.data.text; // Get the recognized text
    //console.log(txt); // Output the recognized text

    // Initialize an empty object to store subjects and grades
    const subjectsAndGrades = {};

    // Split the text into lines
    const lines = txt.split('\n');

    // Define a regular expression pattern to match subjects and grades
    const pattern = /^(\d{4}\s[A-Z\s-]+)\s([A-D]\+?|[A-D]\s?\(CEMERLANG\s?(TINGGI|TERTINGGI)?\)|G\sGAGAL|E\sLULUS|T\sTIDAK\sHADIR)/;

    // Iterate through each line and check for matches
    for (const line of lines) {
        if (pattern.test(line)) {
            const match = line.match(pattern);
            const subject = match[1].trim();
            const grade = match[2].trim();
            subjectsAndGrades[subject] = grade;
        }
    }

    // Output the subjects and grades
    console.log('Subjects and Grades:');
    for (const subject in subjectsAndGrades) {
        console.log(`${subject}: ${subjectsAndGrades[subject].charAt(0)}`);
    }

    return subjectsAndGrades;
};



const imgTotxt = async (img) => {
    const out = await tessaract.recognize(img, 'eng', {});
    const txt = out.data.text; // Get the recognized text
    //console.log(txt); // Output the recognized text

    // Initialize an empty object to store subjects and grades
    const subjectsAndGrades = {};

    // Define a regular expression pattern to match subjects and grades
    const pattern = /([A-Z\s-]+)\s+([A-D]\+?|\w-\+?)\s?\(([^)]+)\)/g;


    // Iterate through each match in the recognized text
    let match;

    while ((match = pattern.exec(txt)) !== null) {
        const subject = match[1].trim();
        const grade = match[2].trim();
        subjectsAndGrades[subject] = grade;
    }

    // while ((match = pattern.exec(txt)) !== null) {
    //     const subject = match[1].trim();
    //     const grade = match[2].trim() + ' (' + match[3].trim() + ')';
    //     subjectsAndGrades[subject] = grade;
    // }

    // Output the subjects and grades
    console.log('Subjects and Grades:');
    for (const subject in subjectsAndGrades) {
        console.log(`${subject}: ${subjectsAndGrades[subject]}`);
    }

    return subjectsAndGrades;
};

imgTotxt(img);
imgTotxt2(img2);