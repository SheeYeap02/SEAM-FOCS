// script.mjs
import data from './json/externalAdvisor.json';

for (const attributeName in data) {
  const newElement = document.createElement("p");
  newElement.innerHTML = attributeName;
  document.getElementById("ResearchDropDown").appendChild(newElement);
  console.log(attributeName);
}