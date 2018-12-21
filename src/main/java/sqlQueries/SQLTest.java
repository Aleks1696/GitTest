package sqlQueries;

//Static imports
import static sqlQueries.queries.alter.Alter.*;
import static sqlQueries.queries.createTable.CreateTable.*;
import static sqlQueries.queries.delete.Delete.*;
import static sqlQueries.queries.insert.Insert.*;
import static sqlQueries.queries.select.Select.*;
import static sqlQueries.queries.update.Update.*;

import java.sql.*;

// SQL - Structured(Standardized) query language
// JDBC - Java Database Connection

/*SQL DataTypes:
*   numbers:
*           INT(size)
*           BIGINT(size)
*           FLOAT(size, number of digits after comma)
 *          DOUBLE(size, n of d after comma)
 *          TINYINT(size) - byte
 *          SMALLINT(size) - short
 *          MEDIUMINT(size)
 *          DECIMAL(size, n of d aft.com) - double stored as a string
 *
 *  text:
 *       CHAR(size) - holds a fixed length string
 *       VARCHAR(size) - up to 255 characters only, if more than converts to TEXT
 *       TINYTEXT - up to 255 ch
 *       TEXT - holds long strings up to 65 535 ch
 *       MEDIUMTEXT/LONGTEXT
 *       BLOB - Binary Large Objects - for media files
 *       MEDIUMBLOB/LONGBLOB
 *       ENUM(x,y,z...) - lets enter list of possible values
 *       SET - up to 64 values. Same as ENUM
 *
 *  date:
 *      DATE() - format YYYY-MM-DD
 *      DATETIME - format YYYY-MM-DD HH:MI:SS
 *      TIMESTAMP - time from unix epoch 1970
 *      TIME - format HH:MI:SS
 *      YEAR - format 1996 or 96
 *       */

public class SQLTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        System.out.println(Class.forName("com.mysql.jdbc.Driver"));

//        createTable();
//        insert1();
//        update1();
//        delete1();
//        select1();
//        insertBatch();
//        select2();
//        insertPerson();
//        select3();
//        select4();
//        select5();
//        select6();
//        select7();
//        select8();
//        createTable1();
//        createTeble2();
//        insert();
//        createTabla3();
//        insertCustomer_Order();
//        selectJoin();
//        selectLeftJoin();
//        selectRightJoin();
//        selectUnion();
//        alterAdd();
//        alterDrop();
//        alterRenameTable();
//        update2();
    }

}
