package homework4;

import java.util.Random;
import java.util.Scanner;

public class ConsoleGame {
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    //Описание персонажа
    public static String playerName = "Lancelot";
    public static char player = '@';
    public static int playerHealth = 100;
    public static int playerPower = 10;
    public static int playerCoins = 0;
    public static int playerExp = 0;
    public static int playerPosX;
    public static int playerPosY;
    public static final int playerMoveUp = 8;
    public static final int playerMoveDown = 2;
    public static final int playerMoveLeft = 4;
    public static final int playerMoveRight = 6;

    //Оисание врага
    public static char enemy = 'E';
    public static int enemyHealth;
    public static int enemyPower;
    public static int enemiesCount;
    public static int enemyValueMin = 20;
    public static int enemyValueMax = 50;

    //Описание карты(игрового поля)
    public static int mapWidth;
    public static int mapHeight;
    public static int mapSizeMin = 2;
    public static int mapSizeMax = 5;
    public static char[][] map;
    public static char[][] invisibleMap; //вторая карта которую будет видеть юзер, на которой не видно врагов
    public static char emptyCell = '_';
    public static char coinsCell = 'C';
    public static char ready = '*';
    public static int levelCount = 0;

    public static void main(String[] args) {

        while (isPlayerAlive()) {
            ++levelCount;
            System.out.println(">>>>> START LEVEL " + levelCount + " <<<<<");
            levelCycle();
        }

        System.out.println(">>>>> GAME OVER! " + playerName + " ready " + levelCount + " level(s) <<<<<");

    }

    public static void levelCycle() {

        createMap();
        spawnPlayer();
        spawnEnemies("Enemy", enemy);
        spawnEnemies("Coins", coinsCell);

        while (true) {
            showMap();
            playerMoveAction();

            if (!isPlayerAlive()) {
                System.out.println(playerName + " is dead. Count coins = " + playerExp);
                break;
            }

            if (!isEnemyExist()) {
                System.out.println(playerName + " is win. Count coins = " + playerExp);
                break;
            }
        }
    }


    //Создание карты(игрового поля)
    public static void createMap() {
        mapWidth = randomValue(mapSizeMin, mapSizeMax);
        mapHeight = randomValue(mapSizeMin, mapSizeMax);
        map = new char[mapHeight][mapWidth];
        invisibleMap = new char[mapHeight][mapWidth];

        for (int y = 0; y < mapHeight; y++) {
            for(int x = 0; x < mapWidth; x++) {
                map[y][x] = emptyCell;
                invisibleMap[y][x] = emptyCell; //приравниваем ширину и высоту так же как и обычной карты
            }
        }
        System.out.println("Create map [" + mapWidth + "x" + mapHeight + "]");
    }

    public static void showMap() {
        System.out.println("=========== MAP ===========");
        for (int y = 0; y < mapHeight; y++) {
            for(int x = 0; x < mapWidth; x++) {
                System.out.print(map[y][x] + "|");
            }
            System.out.println();
        }
        System.out.println("===========================");
    }

    //Расстановка персонажа
    public static void spawnPlayer() {
        playerPosX = randomValue(0, mapWidth - 1);
        playerPosY = randomValue(0, mapHeight - 1);
        map[playerPosY][playerPosX] = player;
        System.out.println(playerName + " has spawn in [" + playerPosY + ":" + playerPosX + "]");

    }

    //Свойства врага
    public static void spawnEnemies(String nameItem, char item) {
        int itemCount = getFreeCells() / 2;

        if (item == enemy) {
            enemyHealth = randomValue(enemyValueMin, enemyValueMax);
            enemyPower = randomValue(enemyValueMin, enemyValueMax);
            enemiesCount = itemCount; //random math.formula
        }

        int enemyPosX;
        int enemyPosY;

        for (int i = 1; i <= enemiesCount; i++) {

            do {
                enemyPosX = random.nextInt(mapWidth);
                enemyPosY = random.nextInt(mapHeight);
            } while (isCellClear(enemyPosX, enemyPosY, invisibleMap) || isCellClear(enemyPosX, enemyPosY, map));
            invisibleMap[enemyPosY][enemyPosX] = item; //врагов помещаем не на основную карту, а на невидимую карту
        }
        System.out.println((nameItem + " count: " + itemCount + ". HP=" + enemyHealth + ", PWR=" + enemyPower));
    }

    //Движение персонажа
    public static void playerMoveAction() {
        int playerLastPositionX = playerPosX;
        int playerLastPositionY = playerPosY;

        int playerMoveCode;

        do {
            System.out.print("Enter destination: (UP-" + playerMoveUp + "|DOWN-" + playerMoveDown +
                    "|LEFT-" + playerMoveLeft + "|RIGHT-" + playerMoveRight + ") > ");
            playerMoveCode = scanner.nextInt();

            switch (playerMoveCode) {
                case playerMoveUp:
                    playerPosY -= 1;
                    break;
                case playerMoveDown:
                    playerPosY += 1;
                    break;
                case playerMoveLeft:
                    playerPosX -= 1;
                    break;
                case playerMoveRight:
                    playerPosX += 1;
                    break;
                default:
                    System.out.println("Your enter value " + playerMoveCode + " is mistake, try again");
                    break;
            }

        } while (!isValidPlayerMove(playerLastPositionX, playerLastPositionY, playerPosX, playerPosY));

        playerNextCellAction();

        map[playerLastPositionY][playerLastPositionX] = ready;
        map[playerPosY][playerPosX] = player;
        map[playerLastPositionY][playerLastPositionX] = emptyCell;

    }

    public static boolean isValidPlayerMove(int lastX, int lastY, int nextX, int nextY) {
        if(isCellValid(nextX, nextY)) {
            System.out.println(playerName + " has move to [" + nextY + ":" + nextX + "]");
            return true;
        } else {
            System.out.println(playerName + " move to [" + nextY + ":" + nextX + "] invalid");
            playerPosX = lastX;
            playerPosY = lastY;
            return false;
        }
    }

    public static void playerNextCellAction(){
        if (invisibleMap[playerPosY][playerPosX] == enemy) {
            battle(playerPosX,playerPosY);
        }
    }

    public static void battle(int x, int y) {
        int battleRoundCount = 1;
        int currentEnemyHealth = enemyHealth;

        System.out.println("=== START BATTLE ===");

        while (isPlayerAlive() && currentEnemyHealth > 0) {
            System.out.println("=== ROUND BATTLE " + battleRoundCount + " ===");
            System.out.println("PlayerHP: " + playerHealth + " PlayerAtk: " + playerPower);
            System.out.println("EnemyHP: " + currentEnemyHealth + " EnemyAtk: " + enemyPower);
            currentEnemyHealth -= playerPower;
            System.out.println("Player give damage to Enemy. Enemy HP is " + currentEnemyHealth);
            if (currentEnemyHealth > 0) {
                playerHealth -= enemyPower;
                System.out.println("Enemy give damage to Player. Player HP is " + playerHealth);
            } else {
                enemiesCount --;
                invisibleMap[y][x] = emptyCell;
                playerExp = enemyHealth + enemyPower;
                break;
            }
            battleRoundCount++;
        }
        System.out.println("=== END BATTLE ===");
    }

    public static int randomValue(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

    public static boolean isCellClear(int x, int y, char[][] map) { //в метод добавилось условие, какую карту необходимо проверять, видимую или невидемую
        return map[y][x] != emptyCell;
    }

    public static boolean isCellValid(int x, int y) {
        return x >= 0 && x < mapWidth && y >= 0 && y < mapHeight;
    }

    public static boolean isPlayerAlive(){
        return  playerHealth > 0;
    }

    public static boolean isEnemyExist(){
        return enemiesCount > 0;
    }

    public static int getFreeCells() { //метод посчета клеток игрового поля, минс клетка на которой стоит сам игрок
        int tmp = 0;
        for (char[] chars : invisibleMap) {
            for (char aChar : chars) {
                if (aChar == emptyCell) {
                    tmp++;
                }
            }
        }
        return tmp - 1;
    }
}
