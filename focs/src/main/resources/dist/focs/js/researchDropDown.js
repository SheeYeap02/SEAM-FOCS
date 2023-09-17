// script.js
import data from './json/externalAdvisor.json';

//displayProducts();
test();

async function test() {
  console.log("test");
}

// Function to display products on the page
async function displayProducts() {
  console.log("display Advisor");
  const container = document.getElementById("ResearchDropDown");
  let html = "";
  for (let i = 0; i < data.length; i++) {
    console.log(data[i]);
    const html2 = await getProductHtml(data); // Wait for the promise to resolve
    html += html2;
  }
  container.innerHTML = html;

  //container.insertAdjacentHTML("beforeend", html);

}

// Function to generate HTML for a single product
async function getProductHtml(id) {
  return `
  <p>${id}</p>
`;
}