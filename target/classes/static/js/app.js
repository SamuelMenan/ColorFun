document.addEventListener('DOMContentLoaded', () => {
  const svgContainer = document.getElementById('svgContainer');
  if (!svgContainer) return;

  // Generar paleta cromática (hue 0..330 paso 30) + tonos neutros + extras
  const hues = Array.from({length: 12}, (_, i) => i * 30); // 0,30,...330
  const chromatic = hues.flatMap(h => [
    `hsl(${h} 90% 55%)`,
    `hsl(${h} 85% 40%)`
  ]);
  const neutrals = ['#ffffff', '#f5f5f5', '#e0e0e0', '#bdbdbd', '#757575', '#424242', '#212121'];
  const accents = ['#ff6f61', '#ffa600', '#ffd54f', '#8bc34a', '#26a69a', '#2196f3', '#3f51b5', '#9c27b0'];
  const paletteColors = [...chromatic, ...accents, ...neutrals];

  let currentColor = paletteColors[0];
  const paletteContainer = document.getElementById('dynamicPalette');

  function renderPalette() {
    paletteContainer.innerHTML = '';
    paletteColors.forEach(color => {
      const btn = document.createElement('button');
      btn.className = 'color';
      btn.style.background = color;
      btn.setAttribute('data-color', color);
      btn.title = color;
      btn.addEventListener('click', () => {
        currentColor = color;
        document.querySelectorAll('.color').forEach(b => b.classList.remove('active'));
        btn.classList.add('active');
      });
      paletteContainer.appendChild(btn);
    });
    // Activar el primero
    const first = paletteContainer.querySelector('.color');
    if (first) first.classList.add('active');
  }

  renderPalette();

  const eraser = document.getElementById('eraser');
  if (eraser) eraser.addEventListener('click', () => {
    currentColor = '#ffffff';
    document.querySelectorAll('.color').forEach(b => b.classList.remove('active'));
    eraser.classList.add('active');
  });

  function attachRegionHandlers() {
    const regions = svgContainer.querySelectorAll('.region');
    regions.forEach(r => {
      r.style.transition = 'fill 0.15s ease';
      r.addEventListener('click', () => {
        try { r.setAttribute('fill', currentColor); } catch (e) {}
      });
    });
  }
  attachRegionHandlers();
});
