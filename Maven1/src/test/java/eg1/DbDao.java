package eg1;

/**
 * <p>Project: Maven1 - eg1.DbDao
 * <p>Powered by Gudark On 2021/12/23 16:22
 * <p>Created by IntelliJ IDEA
 *
 * @author Gudark [1@Zeast.uu.me]
 * @version 1.0
 * @since jdK 17
 */
public interface DbDao {
    int pf(int i);

    static int lf(int n){
        return n*n*n;
    }
}
