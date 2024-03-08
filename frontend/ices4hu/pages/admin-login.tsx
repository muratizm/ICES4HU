import { Button, Grid, TextField } from "@mui/material";
import styles from "@/styles/AdminLogin.module.css";
import React, { useState } from "react";
import { authLogin } from "./jwtOperations";
import axios from "axios";

export default function AdminLogin() {
  const [username, setUsername] = useState<string>("admin");
  const [password, setPassword] = useState<string>("abc1234");

  const authenticate = async (username: string, password: string) => {
    authLogin(username, password);
    const departments = axios.get("localhost:8080/api/v1/departments");
    console.log(departments);
  };

  return (
    <div className={styles.main}>
      <Grid container spacing={2} rowSpacing={2}>
        <Grid item xs={12}>
          <TextField
            id="filled-basic"
            label="Username"
            variant="filled"
            value={username}
            onChange={(event: React.ChangeEvent<HTMLInputElement>) => {
              setUsername(event.target.value);
            }}
          />
        </Grid>
        <Grid item xs={12}>
          <TextField
            id="filled-basic"
            label="Password"
            variant="filled"
            value={password}
            onChange={(event: React.ChangeEvent<HTMLInputElement>) => {
              setPassword(event.target.value);
            }}
          />
        </Grid>
        <Grid item xs={12}>
          <Button
            variant="contained"
            onClick={() => {
              console.log("clicked");
            }}
          >
            Login
          </Button>
        </Grid>
      </Grid>
    </div>
  );
}
