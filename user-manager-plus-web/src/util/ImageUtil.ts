class ImageUtil {
    private static canvas: HTMLCanvasElement
    public static compress (base64: string, option: { w: number; h: number; level: number }): Promise<string> {
      return new Promise((resolve, reject) => {
        const image = new Image()
        image.src = base64
        image.onload = (e) => {
          const wratio = option.w / image.width
          const hratio = option.h / image.height
          if (wratio <= hratio) {
            option.h = wratio * image.height
          } else {
            option.w = hratio * image.width
          }
          if (!this.canvas) {
            this.canvas = document.createElement('canvas')
          }
          this.canvas.width = option.w
          this.canvas.height = option.h
          const context = this.canvas.getContext('2d')
          if (context !== null) {
            context.drawImage(image, 0, 0, option.w, option.h)
            const data = this.canvas.toDataURL('image/jpg', option.level)
            resolve(data)
          }
        }
      })
    }
}

export default ImageUtil
