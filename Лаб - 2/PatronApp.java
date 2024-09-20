package KI306_Chesanovskyi_Lab2;

import java.io.FileNotFoundException;

public class PatronApp{
    public static void main(String[] args) throws FileNotFoundException{
        Patron patron = new Patron(10, 'f', false, false);

        // Виведення інформації про патрон
        patron.ShowInfoOfPatron();  

        // Постріл
        patron.ShootPatron();

        // Постріл
        patron.ShootPatron();

        // Перезарядка
        patron.ReloadPatron();

        // Внесення патрону під заборону
        patron.BanPatron();

        // Постріл
        patron.ShootPatron();

        // Заміна калібру кулі
        patron.ChangeCaliberPatron(5.56);

        // Винесення патрону з-під заборони
        patron.UnBanPatron();

        // Кінець операцій над патроном
        patron.EndOperationsPatron();
    }
}