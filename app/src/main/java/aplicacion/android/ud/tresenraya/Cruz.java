package aplicacion.android.ud.tresenraya;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class Cruz extends View {

    private Paint drawPaint;

    public Cruz(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupPaint();
    }

    private void setupPaint() {
        drawPaint = new Paint();
        drawPaint.setColor(Color.CYAN);
        drawPaint.setStrokeWidth(30);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Path trazo = new Path();
        trazo.moveTo(70,70);
        trazo.lineTo(200,200);
        canvas.drawPath(trazo,drawPaint);
        trazo.moveTo(70,200);
        trazo.lineTo(200,70);
        canvas.drawPath(trazo,drawPaint);
    }
}