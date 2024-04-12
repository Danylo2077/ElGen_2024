const saveTokenToLocalStorage = (token) => {
    localStorage.setItem('token', token);
    console.log("savetoken "+token);
};

export { saveTokenToLocalStorage };