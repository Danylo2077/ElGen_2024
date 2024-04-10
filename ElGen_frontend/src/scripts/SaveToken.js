const saveTokenToLocalStorage = (token) => {
    localStorage.setItem('token', token);
};

export { saveTokenToLocalStorage };