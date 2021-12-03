
const getProducts = () => {
    return fetch('/api/products')
        .then(response => response.json())
        .catch(error => console.log(error));
}


(() => {
    console.log("It works");

    getProducts()
        //.then(products => create html str with prod)
        .then(products => console.log(products))
})();