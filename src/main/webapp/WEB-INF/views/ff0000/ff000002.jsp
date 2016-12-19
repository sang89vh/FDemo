<script>
			var chartData = [];
			generateChartData();


			function generateChartData() {
				var firstDate = new Date();
				firstDate.setHours(0, 0, 0, 0);
				firstDate.setDate(firstDate.getDate() - 2000);

				for (var i = 0; i < 2000; i++) {
					var newDate = new Date(firstDate);

					newDate.setDate(newDate.getDate() + i);

					var open = Math.round(Math.random() * (30) + 100);
					var close = open + Math.round(Math.random() * (15) - Math.random() * 10);

					var low;
					if (open < close) {
						low = open - Math.round(Math.random() * 5);
					} else {
						low = close - Math.round(Math.random() * 5);
					}

					var high;
					if (open < close) {
						high = close + Math.round(Math.random() * 5);
					} else {
						high = open + Math.round(Math.random() * 5);
					}

					var volume = Math.round(Math.random() * (1000 + i)) + 100 + i;

					var value = Math.round(Math.random() * (30) + 100);

					chartData[i] = ({
						date: newDate,
						open: open,
						close: close,
						high: high,
						low: low,
						volume: volume,
						value: value
					});
				}
			}

			

		</script>

		<div id="chartdiv" style="width:100%; height:600px;"></div>
	