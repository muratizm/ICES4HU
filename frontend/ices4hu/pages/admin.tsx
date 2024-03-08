import useLocalStorage from "@/useLocalStorage";

export default function Admin() {
  // Get the value from local storage if it exists
  const [token, setToken] = useLocalStorage("token", "");

  return (
    <>{token !== undefined ? <div>Admin</div> : <div>Not Authorized</div>}</>
  );
}
