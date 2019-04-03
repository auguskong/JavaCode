/**
* Date: 05/23/18
*
*
*/

public int[] asteroidCollision(int[] asteroids) {
	if (asteroids.length < 2) {
		return asteroids;
	}

	int curr = 1;
	int prev = 0;
	while (curr < asteroids.length) {
		if (prev == -1) {
			asteroids[0] = asteroids[curr];
			prev = 0;
			curr++;
			continue;
		} else {
			//there would be a collision
			if (asteroids[prev] > 0 && asteroids[curr] < 0) {
				if (Math.abs(asteroids[prev]) == Math.abs(asteroids[curr])) {
					//both disappear
					prev--;
					curr++;
				}
				else if (Math.abs(asteroids[prev]) > Math.abs(asteroids[curr])) {
					//curr disappear
					curr++;
				}
				else {
					//prev disappear
					prev--;
				}
			} else {
				//no collision happens
				prev++;
				asteroids[prev] = asteroids[curr];
				curr++;
			}
		}
	}
	return Arrays.copyOf(asteroids, prev + 1);
}