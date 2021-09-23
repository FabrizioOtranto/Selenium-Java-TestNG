package reportes;

import org.monte.media.Format;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.VideoFormatKeys.*;
import static org.monte.media.VideoFormatKeys.QualityKey;

public class videoReport extends ScreenRecorder {
    private String name;
    private ScreenRecorder screenRecorder;
    public videoReport(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat, Format screenFormat, Format mouseFormat,
                       Format audioFormat, File movieFolder, String name) throws IOException, AWTException {
        super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
        this.name = name;
    }

    @Override
    protected File createMovieFile(Format fileFormat) throws IOException {
        if(!movieFolder.exists()){
            movieFolder.mkdirs();
        }else if(!movieFolder.isDirectory()){
                throw new IOException("\"" + movieFolder + "\" is not a directory");
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH");
        return new File(movieFolder, name + "-" + dateFormat.format(new Date()) + "." + Registry.getInstance().getExtension((fileFormat)));
    }

    public void stopRecording() throws IOException {
        this.screenRecorder.stop();
    }

    public void startRecording(String videoPath) throws IOException, AWTException {
        File file = new File(videoPath);
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        Rectangle captureSize = new Rectangle(0, 0, 1920, 1000);
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();

        this.screenRecorder = new videoReport(gc, captureSize,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                        QualityKey, 1.0f, KeyFrameIntervalKey, 15*60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                null, file, "CP001");

        this.screenRecorder.start();
    }

}
