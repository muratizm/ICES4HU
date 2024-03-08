import axios from "axios";

const baseAuthURL = "localhost:8080/api/v1/auth/";

const authLogin = async (username: string, password: string) => {
    const loginPayload = {
        username, password
    }
    await axios.post(baseAuthURL + "authenticate", loginPayload)
        .then(response => {
            //get token from response
            const token = response.data.token;

            //set JWT token to local
            localStorage.setItem("token", token);

            //set token to axios common header
            setAxiosHeaderAuth(token);
        })
        .catch(err => console.log(err));
};

const setAxiosHeaderAuth = (token: string) => {
    if (token) {
        axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
    }
    else
        delete axios.defaults.headers.common["Authorization"];
}

export { authLogin, setAxiosHeaderAuth };