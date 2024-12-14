package entity;

import engine.DrawManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;


public class BossBullet extends Entity {

    private BufferedImage bulletImage;
    private int attackType; // 0 : 보스1 기본 미사일 / 1 : 보스1 미사일
    private static Logger logger;
    private int SAVED_Y;

    /**
     * Constructor, establishes the entity's generic properties.
     *
     * @param positionX Initial position of the entity in the X axis.
     * @param positionY Initial position of the entity in the Y axis.
     * @param width     Width of the entity.
     * @param height    Height of the entity.
     */
    public BossBullet(double positionX, double positionY, int width, int height, int type) {
        super(positionX, positionY, width, height, Color.WHITE);
        this.attackType = type;
        SAVED_Y = (int) positionY;
        switch (type) {
            case 0:
                try {
                    bulletImage = loadImageforJAR("image/missile00.png");
                } catch (Exception e) {
                    logger.info("Boss Bullet image loading failed.");
                }
                break;
            case 1:
                try {
                    bulletImage = loadImageforJAR("image/missile01.png");
                } catch (Exception e) {
                    logger.info("Boss Bullet image loading failed.");
                }
                break;
            case 2:
                try {
                    bulletImage = loadImageforJAR("image/missile02.png");
                } catch (Exception e) {
                    logger.info("Boss Bullet image loading failed.");
                }
                break;
            case 3:
                try {
                    bulletImage = loadImageforJAR("image/missile03.png");
                } catch (Exception e) {
                    logger.info("Boss Bullet image loading failed.");
                }
                break;
            case 4:
                try {
                    bulletImage = loadImageforJAR("image/star01.png");
                } catch (Exception e) {
                    logger.info("Boss Bullet image loading failed.");
                }
                break;
            case 5:
                try {
                    bulletImage = loadImageforJAR("image/star02.png");
                } catch (Exception e) {
                    logger.info("Boss Bullet image loading failed.");
                }
                break;
            case 6:
                try {
                    bulletImage = loadImageforJAR("image/star03.png");
                } catch (Exception e) {
                    logger.info("Boss Bullet image loading failed.");
                }
                break;
            case 7:
                try {
                    bulletImage = loadImageforJAR("image/star04.png");
                } catch (Exception e) {
                    logger.info("Boss Bullet image loading failed.");
                }
                break;
            case 8:
                try {
                    bulletImage = loadImageforJAR("image/star05.png");
                } catch (Exception e) {
                    logger.info("Boss Bullet image loading failed.");
                }
                break;
            case 9:
                try {
                    bulletImage = loadImageforJAR("image/star06.png");
                } catch (Exception e) {
                    logger.info("Boss Bullet image loading failed.");
                }
                break;
            default:
                break;

        }
    }

    public BufferedImage getBulletImage() { return this.bulletImage; }

    public final void move(final double distanceX, final double distanceY) {
        this.positionX += distanceX;
        this.positionY += distanceY;
    }

    public int getAttackType () { return this.attackType; }

    public int getSAVED_Y() {return this.SAVED_Y;}

    private static BufferedImage loadImageforJAR(String path) {
        try {
            // 클래스 이름을 사용해 ClassLoader를 불러오기
            InputStream is = DrawManager.class.getClassLoader().getResourceAsStream(path);
            if (is == null) {
                throw new IllegalArgumentException("Resource not found: " + path);
            }
            return ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
