package kpfu.ITIS.Semestrovka1.Java.Daos;

import kpfu.ITIS.Semestrovka1.Java.model.HavingId;

import java.sql.*;

//только классы будут T, класс наследуется от интерфейса?
public class DaoHelper<T extends HavingId> {
    void checkingСhanges(PreparedStatement statement) {
        try {
            if (statement.executeUpdate() == 0) {
                //Если ничего не было изменено, значит возникла ошибка
                //Возбуждаем соответсвующее исключений
                throw new SQLException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void setId(PreparedStatement statement, T model) {
        //Достаём созданное Id пользователя
        try (ResultSet set = statement.getGeneratedKeys();) {
            //Если id  существет,обновляем его у подели.
            if (set.next()) {
                model.setId(set.getInt(1));
            } else {
                //Модель сохранилась но не удаётся получить сгенерированный id
                //Возбуждаем соответвующее исключение
                throw new SQLException();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
