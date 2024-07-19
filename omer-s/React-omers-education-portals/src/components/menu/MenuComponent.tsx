import { Stack } from "react-bootstrap";
import { NavLink } from "react-router-dom";


export default function MenuComponent() {
 

  return (
    <Stack>
      
      <Stack gap={2}>
        <NavLink to="/">Anasayfa</NavLink>
        <NavLink className={({ isActive }) => (isActive ? "bg-info" : "")} to="/course" end>
          Kurslar
        </NavLink>
        <NavLink to="/course/save" className={({ isActive }) => (isActive ? "bg-info" : "")}>
          Kurs Kaydet
        </NavLink>
        <NavLink to="/user" className={({ isActive }) => (isActive ? "bg-info" : "")} end>
          Kullanıcılar
        </NavLink>
        <NavLink to="/user/save" className={({ isActive }) => (isActive ? "bg-info" : "")}>
          Kullanıcı Kaydet
        </NavLink>
        <NavLink to="/lesson" className={({ isActive }) => (isActive ? "bg-info" : "")} end>
          Dersler
        </NavLink>
        <NavLink to="/lesson/save" className={({ isActive }) => (isActive ? "bg-info" : "")}>
          Ders Kaydet
        </NavLink>
        <NavLink to="/review" className={({ isActive }) => (isActive ? "bg-info" : "")} end>
          Yorumlar
        </NavLink>
        <NavLink to="/review/save" className={({ isActive }) => (isActive ? "bg-info" : "")}>
          Yorum Kaydet
        </NavLink>
        <NavLink to="/teacher" className={({ isActive }) => (isActive ? "bg-info" : "")} end>
          Öğretmenler
        </NavLink>
        <NavLink to="/teacher/save" className={({ isActive }) => (isActive ? "bg-info" : "")}>
          Öğretmen Kaydet
        </NavLink>
        <NavLink to="/enrollment" className={({ isActive }) => (isActive ? "bg-info" : "")} end>
          Kayıtlar
        </NavLink>
        <NavLink to="/enrollment/save" className={({ isActive }) => (isActive ? "bg-info" : "")}>
          Kayıt Ekle
        </NavLink>
      </Stack>
    </Stack>
  );
}
