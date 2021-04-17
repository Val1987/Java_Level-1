package lesson7;

// Tigashov Valeriy

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class GameMap extends JPanel {

    public static final int GAME_MODE_HVH = 0;
    public static final int GAME_MODE_HVA = 1;

    private final int HUMAN = 1;
    private final int AI = 2;
    private final int EMPTY = 0;

    private final int PADDING_DOT = 5;

    private final Random RANDOM = new Random();

    private final String MSG_WIN_HUMAN = "HUMAN WIN !!!!";
    private final String MSG_WIN_AI = "AI WIN !!!!";
    private final String MSG_WIN_DRAW = "DRAW !!!!";

    private final int STATE_WIN_HUMAN = 0;
    private final int STATE_WIN_AI = 1;
    private final int STATE_WIN_DRAW = 2;
    private int stateGameOver;

    private int[][] map;
    private int mapSizeX;
    private int mapSizeY;
    private int modeGame;
    private int winLength;

    private int cellWidth;
    private int cellHeight;

    private boolean gameOver;
    private boolean initMap;

    GameMap() {
        setBackground(Color.BLACK);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                update(e);
            }
        });
        initMap = false;
    }

    void startGame(int modeGame, int mapSizeX, int mapSizeY, int winLength) {
        this.mapSizeX = mapSizeX;
        this.mapSizeY = mapSizeY;
        this.winLength = winLength;
        this.modeGame = modeGame;
        map = new int[mapSizeY][mapSizeX];
        gameOver = false;
        initMap = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void update(MouseEvent e) {
        if (!initMap) return;
        if (gameOver) return;

        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) {
            return;
        }
        map[cellY][cellX] = HUMAN;

        if (checkWin(HUMAN)) {
            setGameOver(STATE_WIN_HUMAN);
            return;
        }

        if (isFullMap()) {
            setGameOver(STATE_WIN_DRAW);
            return;
        }

        aiTurn();
        repaint();

        if (checkWin(AI)) {
            setGameOver(STATE_WIN_AI);
            return;
        }

        if (isFullMap()) {
            setGameOver(STATE_WIN_DRAW);
            return;
        }
    }

    private void setGameOver(int stateGameOver){
        gameOver = true;
        this.stateGameOver = stateGameOver;
        repaint();
    }

    private void render(Graphics g) {
        if (!initMap) return;

        createMap(g);

        for (int y = 0; y < mapSizeY; y++) {
            for (int x = 0; x < mapSizeX; x++) {
                if (isEmptyCell(x, y)) continue;
                if (map[y][x] == HUMAN) {
                    g.setColor(Color.GREEN);
                    g.fillOval(x * cellWidth + PADDING_DOT, y * cellHeight + PADDING_DOT, cellWidth - PADDING_DOT * 2, cellWidth - PADDING_DOT * 2);
                } else if (map[y][x] == AI) {
                    g.setColor(Color.RED);
                    g.fillOval(x * cellWidth + PADDING_DOT, y * cellHeight + PADDING_DOT, cellWidth - PADDING_DOT * 2, cellWidth - PADDING_DOT * 2);
                } else {
                    throw new RuntimeException("Something wrong in render: incorrect draw Object in " + y + ":" + x);
                }
            }
        }
        if (gameOver) {
            showWinMessage(g);
        }
    }

    private void showWinMessage(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0, 200, getWidth(), 70);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Times New Roman", Font.BOLD, 45));

        switch (stateGameOver) {
            case STATE_WIN_HUMAN:
                g.drawString(MSG_WIN_HUMAN, 70, getHeight() / 2);
                break;
            case STATE_WIN_AI:
                g.drawString(MSG_WIN_AI, 150, getHeight() / 2);
                break;
            case STATE_WIN_DRAW:
                g.drawString(MSG_WIN_DRAW, 150, getHeight() / 2);
                break;
            default:
                throw new RuntimeException("Incorrect state game over: " + stateGameOver);
        }
    }

    private void createMap(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        cellWidth = width / mapSizeX;
        cellHeight = height / mapSizeY;

        g.setColor(Color.WHITE);

        for (int i = 0; i < mapSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, width, y);
        }

        for (int i = 0; i < mapSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, height);
        }
    }

    public void aiTurn() {
        if (turnAIWinCell()) { //выиграет ли игрок на следующем ходу?
            return;
        }
        if (turnHumanWinCell()) { //выиграет ли комп на следующем ходу?
            return;
        }
        int x;
        int y;
        do {
            x = RANDOM.nextInt(mapSizeX);
            y = RANDOM.nextInt(mapSizeY);
        } while (!isEmptyCell(x, y));
        map[y][x] = AI;
    }

    private boolean turnAIWinCell() {
        for (int i = 0; i < mapSizeY; i++) {
            for (int j = 0; j < mapSizeX; j++) {
                if (isEmptyCell(j, i)) {
                    map[i][j] = AI;    // поставим нолик в каждую клетку поля по очереди
                    if (checkWin(AI)) {
                        return true;    // если мы выиграли, вернём истину, оставив нолик в выигрышной позиции
                    }
                    map[i][j] = EMPTY;    // если нет - вернём обратно пустоту в клетку и пойдём дальше
                }
            }
        }
        return false;
    }

    // Проверка, выиграет-ли игрок своим следующим ходом
    private boolean turnHumanWinCell() {
        for (int i = 0; i < mapSizeY; i++) {
            for (int j = 0; j < mapSizeX; j++) {
                if (isEmptyCell(j, i)) {
                    map[i][j] = HUMAN;     // поставим крестик в каждую клетку по очереди
                    if (checkWin(HUMAN)) {    // если игрок победит
                        map[i][j] = AI;    // поставить на то место нолик
                        return true;
                    }
                    map[i][j] = EMPTY;    // в противном случае вернуть на место пустоту
                }
            }
        }
        return false;
    }

    // проверка на победу
    private boolean checkWin(int player) {
        for (int i = 0; i < mapSizeX; i++) {     // ползём по всему полю
            for (int j = 0; j < mapSizeY; j++) {
                if (checkLine(i, j, 1, 0, winLength, player)) {
                    return true;    // проверим линию по х
                }
                if (checkLine(i, j, 1, 1, winLength, player)) {
                    return true;    // проверим по диагонали х у
                }
                if (checkLine(i, j, 0, 1, winLength, player)) {
                    return true;    // проверим линию по у
                }
                if (checkLine(i, j, 1, -1, winLength, player)) {
                    return true;    // проверим по диагонали х -у
                }
            }
        }
        return false;
    }

    // проверка линии
    private boolean checkLine(int x, int y, int vx, int vy, int len, int player) {
        final int farX = x + (len - 1) * vx;    // посчитаем конец проверяемой линии
        final int farY = y + (len - 1) * vy;
        if (!isValidCell(farX, farY)) {
            return false;    // проверим не выйдет-ли проверяемая линия за пределы поля
        }
        for (int i = 0; i < len; i++) {    // ползём по проверяемой линии
            if (map[y + i * vy][x + i * vx] != player) {
                return false;    // проверим одинаковые-ли символы в ячейках
            }
        }
        return true;
    }

    public boolean isFullMap() {
        for (int i = 0; i < mapSizeY; i++) {
            for (int j = 0; j < mapSizeX; j++) {
                if (map[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidCell(int x, int y) {
        return x >= 0 && x < mapSizeX && y >= 0 && y < mapSizeY;
    }

    public boolean isEmptyCell(int x, int y) {
        return map[y][x] == EMPTY;
    }

}
