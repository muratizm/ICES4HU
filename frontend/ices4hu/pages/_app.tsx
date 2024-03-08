"use client";

import { useEffect } from "react";
import "@/styles/globals.css";
import type { AppProps } from "next/app";
import { setAxiosHeaderAuth } from "./jwtOperations";

function SafeHydrate({ children }) {
  return (
    <div suppressHydrationWarning>
      {typeof window === "undefined" ? null : children}
    </div>
  );
}

export default function App({ Component, pageProps }: AppProps) {
  useEffect(() => {
    //check jwt token
    const token = localStorage.getItem("token");
    if (token) {
      setAxiosHeaderAuth(token);
    }
  }, []);
  return (
    <SafeHydrate>
      <Component {...pageProps} />
    </SafeHydrate>
  );
}
